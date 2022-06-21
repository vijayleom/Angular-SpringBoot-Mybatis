import { Component, OnInit} from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { Person } from './person/person';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Person Identification';

  content: number = -1;
  personId: string = '';
  actionValue: number=0;
  baseurl: string = 'http://127.0.0.1:8080/person';
  headers: any = { 'Content-Type': 'application/json', 'responseType': 'text'};


  isResultAvailable: boolean = false;
  isDeleted: boolean = false;
  resultArray: Array<String>= new Array<String>();;

  position= { positionClass:'toast-custom' };

ngOnInit(){
	this.content = 0;
}

constructor(private toastr: ToastrService, public httpClient: HttpClient){
}
public choose(value:number){
	this.actionValue = value;
	this.content = value;
	this.isDeleted = false;
	this.isResultAvailable = false;
	this.personId = '';
	this.resultArray = new Array<String>();
}

public initiateCall(action:string){
	if(this.personId.length == 0 || this.personId.length > 3 || isNaN(Number(this.personId))){
		this.toastr.error("Your ID format/length is incorrect, Please provide numerics with maxlength of 3","Validation Error" );
	} else {
		if(action === 'find'){
			this.httpClient.get<Person>(this.baseurl + '/findperson?personId='+this.personId).subscribe((resp: any) => {
				this.resultArray = new Array<String>();
				this.resultArray[0] = resp['personId'];
				this.resultArray[1] = resp['personFirstName'] + ' ' +  resp['personLastName'];
				this.resultArray[2] = resp['address'];
				this.resultArray[3] = resp['personPhoneNumber'];
				this.toastr.success("Requested person details are successfully fetched.");
				this.isResultAvailable = true;
			}, (error:any) => {
				if(error['status'] === 200){
					this.toastr.error("Requested person unavailable in the database!");
				} else {
					this.toastr.error(error['message']);
				}
			});
		} else if(action === 'delete'){
			this.httpClient.delete(this.baseurl + '/removeperson/'+ this.personId, this.headers).subscribe((resp: any) => {
				this.isDeleted = true;
			}, (error:any) => {
				if(error['status'] === 301){
					this.isDeleted = true;
				} else {
					this.toastr.error(error['message']);
				}
			});
		}
	}
}

public savePersonInfo(){
	if(this.resultArray && this.resultArray.length > 0){
		let condition:Boolean = true;
		let labels:Array<string> = new Array();
		if(!this.resultArray[0] || this.resultArray[0].length === 0){
			condition = false;
			labels.push('First Name');
		}if(!this.resultArray[1] || this.resultArray[1].length === 0){
			condition = false;
			labels.push('Last Name');
		}if(!this.resultArray[2] || this.resultArray[2].length === 0){
			condition = false;
			labels.push('Address');
		}if(!this.resultArray[3] || this.resultArray[3].length < 7 || isNaN(Number(this.resultArray[3]))){
			condition = false;
			labels.push('Phone Number');
		}
		
		if(!condition){
			this.toastr.error("Please provide apt value(s) for "+labels+".");
		} else{
			let content = {
				"personFirstName": String(this.resultArray[0]),
				"personLastName": String(this.resultArray[1]),
				"address": String(this.resultArray[2]),
				"personPhoneNumber": Number(this.resultArray[3])
				};
				
			this.httpClient.post(this.baseurl + '/saveperson', content, this.headers).subscribe((data: any) => {
				this.toastr.success(data);
			}, (error:any) => {
				this.toastr.success(error);
			});
			this.resultArray = new Array<String>();
			this.choose(1);
		}
	} else{
		this.toastr.error("Please provide values prior to suibmitting the page.");
	}
}
}