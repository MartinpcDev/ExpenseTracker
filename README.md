# Expense Tracker

Una aplicación de línea de comandos para gestionar y rastrear tus gastos de forma rápida y sencilla.
Challenge basado en el reto [roadmap.sh](https://roadmap.sh/projects/expense-tracker)

## Características

* Añadir un gasto: Registra un gasto con descripción y cantidad.
* Actualizar un gasto: Modifica un gasto existente.
* Eliminar un gasto: Elimina un gasto de la lista.
* Ver todos los gastos: Muestra la lista completa de gastos registrados.
* Resumen de gastos: Presenta un resumen total de los gastos.
* Resumen mensual: Muestra el resumen de gastos de un mes específico del año actual.

## Instalación

Clona este repositorio:

```
   git clone https://github.com/MartinpcDev/ExpenseTracker.git
```

## Uso

Lista de comandos disponibles:

| Comando                                               | Descripcion                           |
|-------------------------------------------------------|---------------------------------------|
| add --description "<descripcion>" --amount <cantidad> | Agrega expense descripcion y cantidad |
| list                                                  | Lista todas los datos                 |
| summary --month <valor>                               | sumatoria de amount por mes           |
| summary --all                                         | sumatoria total de amount             |
| delete --id <valor>                                   | borra expense por id                  |
| update --id <valor> --description "<string>"          | Actualiza descripcion de la expense   |
| update --id <valor> --amount <valor>                  | Actualiza el amount                   |
| exit                                                  | salir del programa                    |