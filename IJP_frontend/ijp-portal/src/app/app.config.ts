import { APP_INITIALIZER, ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import {AuthConfig, OAuthService, provideOAuthClient} from 'angular-oauth2-oidc';

export const authCodeFlowConfig: AuthConfig = {
  issuer: 'http://localhost:7080/realms/master',
  tokenEndpoint: 'http://localhost:7080/realms/master/protocol/openid-connect/token',
  redirectUri: window.location.origin,
  clientId: 'IJPGrp_3_ac',
  responseType:'code',
  scope:'openId profile',
}

function initializeOAuth(oauthService:OAuthService): Promise<void>{
  return new Promise((resolve)=>{
    oauthService.configure(authCodeFlowConfig);
    oauthService.setupAutomaticSilentRefresh();
    oauthService.loadDiscoveryDocumentAndLogin()
      .then(()=> resolve());
  })
}

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    provideOAuthClient(),
    {
      provide:APP_INITIALIZER,
      useFactory:(oauthService: OAuthService)=>{
        return ()=>{
          initializeOAuth(oauthService)
        }
      },
      multi: true,
      deps:[
        OAuthService
      ]
    }
  ]
};
