import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from 'src/app/model/project';
import { ImageService } from 'src/app/service/image.service';
import { ProjectService } from 'src/app/service/project.service';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  project: Project = null;

  constructor(private activatedRouter: ActivatedRoute, private projectService: ProjectService,
    private router: Router, public imageService: ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.projectService.detail(id).subscribe(
      data => {
        this.project = data;
      }, err => {
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.project.projectVideo = this.imageService.images[1];
    this.projectService.update(id, this.project).subscribe(
      data => {
        window.location.href = "https://frontendportafoliochupitea.web.app/";
      }, err => {
        alert("Error al modificar la información");
        window.location.href = "https://frontendportafoliochupitea.web.app/";
      }
    )
  }

  uploadImage($event: any) {
    const id = this.activatedRouter.snapshot.params['id'];
    const name = "proyect_" + id;
    this.imageService.uploadImage($event, name);
  }

}
