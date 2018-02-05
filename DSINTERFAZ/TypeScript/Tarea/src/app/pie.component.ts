import { Component } from '@angular/core';

@Component ({
    selector: 'pie',
    templateUrl:'./pie.component.html',
    styleUrls: ['./app.pie.component.css']
})
export class PieComponent {
    
    color:string="naranja";
    
    cambiarColor(color:string) {
        this.color = color;
    }
}