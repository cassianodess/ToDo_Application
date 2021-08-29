export interface Todo {
    id?: String, // '?' indica que é um campo opicional
    titulo: String,
    descricao?: String,
    dataParaFinalizar: any,
    finalizado: Boolean

}