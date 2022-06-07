import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/internal/Observable';
import {environment} from "../../../../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class GiphyService {

  constructor(private http: HttpClient) { }
  private apiBaseUrl = 'http://api.giphy.com/v1/';

  public getGIFS(search: string): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.apiBaseUrl}gifs/search?q=${search}&api_key=${environment.apiKey}&limit=24`)
  }

  public getStickers(search: string): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.apiBaseUrl}stickers/search?q=${search}&api_key=${environment.apiKey}&limit=12&lang=en`)
  }
}
