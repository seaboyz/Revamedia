import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GiphyServiceService {

  constructor(private http: HttpClient) { }
  private apiBaseUrl = 'http://api.giphy.com/v1/gifs/search';

  public getGIFS(search: string): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.apiBaseUrl}?q=${search}&api_key=${environment.apiKey}&limit=12`)
  }
}
