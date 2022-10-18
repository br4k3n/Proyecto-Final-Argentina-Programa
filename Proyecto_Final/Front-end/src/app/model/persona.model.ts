export class persona {
    id?: number;
    nombre: string;
    apellido: string;
    subtitulo: string;
    descripcion: string;
    img: string;
    telefono: string;
    ubicacion: string;

    constructor(nombre: string,apellido: string, subtitulo: string, descripcion:string, img: string, telefono: string, ubicacion: string){
        this.nombre = nombre
        this.apellido = apellido;
        this.subtitulo = this.subtitulo;
        this.descripcion = this.descripcion;
        this.img = img;
        this.telefono = this.telefono;
        this.ubicacion = this.ubicacion;
    }
}