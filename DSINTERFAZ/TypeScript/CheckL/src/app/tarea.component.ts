import {Component, Input, Output, EventEmitter} from '@angular/core';
import { Tarea } from './tarea';

@Component({
    selector : 'componenteHijo',
    templateUrl : './tarea.component.html'
})

export class TareaComponent{
    @Input()
    private miTarea: Tarea;

    @Output()
    private eventoBorrar = new EventEmitter<Tarea>();

    borrarTarea(){
        this.eventoBorrar.emit(this.miTarea);
    }
}
