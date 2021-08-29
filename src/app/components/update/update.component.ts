import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from './../../models/Todo';
import { TodoService } from './../../services/todo.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  todo: Todo = {
    titulo: "",
    descricao: "",
    dataParaFinalizar: new Date(),
    finalizado: false
  };
  constructor(private router: Router, private service: TodoService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    //Pega id da url e atribui ao TODO
    this.todo.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }


  findById(): void {
    this.service.findById(this.todo.id).subscribe((resposta) => {
      this.todo = resposta;
    });
  }

  update(): void {
    this.service.update(this.todo).subscribe((resposta) => {
      this.service.message("Tarefa atualizada com sucesso!");
      this.router.navigate(['']);
    }, err => {
      this.service.message("Falha ao atualizar tarefa!");
      this.router.navigate(['']);
    })
  }

  formataData(): void {
    let data = new Date(this.todo.dataParaFinalizar);
    this.todo.dataParaFinalizar = `${data.getDate()}/${data.getMonth()}/${data.getFullYear()}`;
  }

  cancelar(): void {
    this.router.navigate([""]);

  }

}
