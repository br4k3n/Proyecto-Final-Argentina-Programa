import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { persona } from 'src/app/model/persona.model';
import { ImageService } from 'src/app/service/image.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-editcelubi',
  templateUrl: './editcelubi.component.html',
  styleUrls: ['./editcelubi.component.css']
})
export class EditcelubiComponent implements OnInit {
  persona: persona = null;
  constructor(private activatedRouter: ActivatedRoute, private personaService: PersonaService,
    private router: Router, public imageService: ImageService) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaService.detail(id).subscribe(
      data => {
        this.persona = data;
      }, err => {
        alert("Error al modificar");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.persona.img = this.imageService.images[0];
    this.personaService.update(id, this.persona).subscribe(
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
    const name = "perfil_" + id;
    this.imageService.uploadImage($event, name);
  }

}
