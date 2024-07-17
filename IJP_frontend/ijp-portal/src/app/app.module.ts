import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';

import { AppAuthGuard } from './app.authguard';
import {AppA}
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { XyzComponent } from './xyz/xyz.component';
import { FirstpageComponent } from './firstpage/firstpage.component';

const keycloakService = new KeycloakService();

@NgModule({
  declarations: [
    AppComponent,
    XyzComponent,
    FirstpageComponent
  ],
  imports: [
    KeycloakAngularModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [AppAuthGuard, {
    provide: KeycloakService,
    useValue: keycloakService
  }],
  entryComponents: [AppComponent],
})
export class AppModule {
  ngDoBootstrap(app) {
    keycloakService
      .init({
        config: {
          url: 'http://localhost:7080/auth',
          realm: 'IJP',
          clientId: 'IJP-ac',
        },
        initOptions: {
          onLoad: 'login-required',
          checkLoginIframe: false,
        },
        enableBearerInterceptor: true,
        bearerExcludedUrls: [],
      })
      .then(() => {
        app.bootstrap(AppComponent);
      })
      .catch((error) =>
        console.error('[ngDoBootstrap] init Keycloak failed', error)
      );
  }
}
