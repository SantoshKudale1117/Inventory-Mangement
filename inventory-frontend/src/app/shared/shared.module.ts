/**
 * @author Santosh Kudale
 * @email santosh.kudale96@gmail.com
 * @create date 2020-11-03 22:38:27
 * @modify date 2020-11-03 22:38:27
 * @desc Consists of modules shared across components
 */
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterComponent } from './footer/footer.component';
import { NavigationComponent } from './navigation/navigation.component';
import { RouterModule } from '@angular/router';
import { NotFoundComponent } from './not-found/not-found.component';
import { MaterialCustomModule } from '../material-custom/material-custom.module';
import { ErrorDisplayComponent } from './error-display/error-display.component';
import { UpdateStatusComponent } from './update-status/update-status.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';



@NgModule({
  declarations: [
    FooterComponent,
    NavigationComponent,
    NotFoundComponent,
    ErrorDisplayComponent,
    UpdateStatusComponent,
    HeaderComponent,
  ],
  imports: [
    ReactiveFormsModule,
    CommonModule,
    RouterModule,
    MaterialCustomModule
  ],
  exports: [
    FooterComponent,
    NavigationComponent,
    MaterialCustomModule,
    HeaderComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule { }
