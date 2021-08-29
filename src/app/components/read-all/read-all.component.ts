import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoService } from 'src/app/services/todo.service';
import { Todo } from './../../models/Todo';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {

  list: Todo[] = [];
  listFinished: Todo[] = [];
  closed = 0;


  constructor(private service: TodoService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }
  /** Recebe a lista de Todos e insere na list local */
  findAll(): void {
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach(todo => {
        if (todo.finalizado) {
          this.listFinished.push(todo);
        } else {
          this.list.push(todo);
        }
      })
      this.closed = this.listFinished.length
    })
  }

  finalizar(item: Todo): void {
    item.finalizado = true;
    this.service.update(item).subscribe(() => {
      this.service.message("Tarefa concluída com sucesso!");
      this.list = this.list.filter(todo => todo.id !== item.id); //Tirando da lista local
      this.closed++;
    });

  }

  delete(id: any): void {
    this.service.delete(id).subscribe((resposta) => {
      if (resposta === null) {
        this.service.message("Tarefa deletada com sucesso!");
        this.list = this.list.filter(todo => todo.id !== id); //Tirando da lista local
      } else {
        this.service.message("Tarefa  não deletada!");
      }
    })

  }

  tarefasFinalizadas(): void {
    this.router.navigate(['finalizados']); //Volta para página root
  }





}
