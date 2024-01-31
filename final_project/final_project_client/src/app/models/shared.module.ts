import {NgModule} from "@angular/core";
import {ShortPipe} from "./short-pipe";
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    ShortPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [ShortPipe]
})
export class SharedModule { }
