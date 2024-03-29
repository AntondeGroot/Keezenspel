import { Injectable } from "@angular/core";
import { Observable, Observer } from 'rxjs';
import { AnonymousSubject } from 'rxjs/internal/Subject';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';

const CHAT_URL = new URL("ws://localhost:5000");

export interface Message {
  source: string;
  content: string;
}

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  private subject!: AnonymousSubject<MessageEvent>;
  public messages: Subject<Message>;

  constructor() {
    this.messages = <Subject<Message>>this.connect(CHAT_URL).pipe(
      map(
        (response: MessageEvent): Message => {
          console.log(response.data);
          let data = JSON.parse(response.data)
          return data;
        }
      )
    );
  }

  public connect(url: URL): AnonymousSubject<MessageEvent> {
    if (!this.subject) {
      this.subject = this.create(url);
      console.log("Successfully connected: " + url);
    }
    return this.subject;
  }

  private create(url: URL): AnonymousSubject<MessageEvent> {
    let ws = new WebSocket(url);

    let observable = new Observable((obs: Observer<MessageEvent>) => {
      ws.onmessage = obs.next.bind(obs);
      ws.onerror = obs.error.bind(obs);
      ws.onclose = obs.complete.bind(obs);
      return ws.close.bind(ws);
    });

    let observer = {
      next: (event: MessageEvent) => {
        console.log('Message sent to websocket: ', event);
        if (ws.readyState === WebSocket.OPEN) {
          ws.send(JSON.stringify(event.data));
        }
      },
      error: (error: Event) => {
        console.error('websocket error: ', error);
      },
      complete: () => {
        console.log('websocket connection closed.');
      }

    };
    AnonymousSubject
    return new AnonymousSubject<MessageEvent>(observer, observable);
  }
}