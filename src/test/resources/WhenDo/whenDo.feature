Feature: WhenDo

  Scenario Outline: Create un conjunto de tareas en WhenDo

    Given tengo acceso a whenDoApp
    When creo una nueva tarea con titulo <titulo> y descripcion <descripcion>
    Then la tarea <titulo> deberia ser creada

    Examples:
      | titulo  | descripcion  |
      | titulo1 | descripcion1 |
      | titulo2 | descripcion2 |
      | titulo3 | descripcion3 |
      | titulo4 | descripcion4 |
      | titulo5 | descripcion5 |
      | titulo6 | descripcion6 |
