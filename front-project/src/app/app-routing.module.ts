import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { AboutComponent } from './components/pages/about/about.component';
import { NewEmployeeComponent } from './components/pages/new-employee/new-employee.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'employees/new', component: NewEmployeeComponent },
  { path: 'about', component: AboutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
