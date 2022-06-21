import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
	declarations: [
		AppComponent
	],
	imports: [
		BrowserModule,
		HttpClientModule,
		AppRoutingModule,
		FormsModule,
		BrowserAnimationsModule,
		ToastrModule.forRoot({
			timeOut: 5000,
			positionClass: 'toast-top-center',
			preventDuplicates: true,
		}
		)
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
