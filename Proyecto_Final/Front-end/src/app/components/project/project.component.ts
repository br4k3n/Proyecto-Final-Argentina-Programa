import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/model/project';
import { ProjectService } from 'src/app/service/project.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  project: Project = null;


  constructor(private projectService: ProjectService, private tokenService: TokenService) { }

  isLogged = false;
  ngOnInit(): void {
    this.cargarProject();
    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarProject(): void {
    this.projectService.detail(1).subscribe(
      data => {
        this.project = data;
      }
    )
  }

}
