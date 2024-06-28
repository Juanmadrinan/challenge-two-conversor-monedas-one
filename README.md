## Conversion de Monedas de Oracle Next Education - Proyecto consumo de Api (ExchangeRate)

<p>Hola Equipo de Revision de ONE, les presento mi proyecto algo retardado... pero lo logre :), Dios les bendiga ^-^</p>

<h2>Presentacion del Conversor de Monedas</h2>
<p>Este proyecto se explicara desde la Api utilizada, factores importantes en la logica del proyecto, tipos de datos utilizados y demas componentes importantes a explicar, en el siguiente listado se presenta:</p>
<ul>
  <li>Explicación de la API</li>
  <li>Estructura y Logica del Proyecto (Explicacion en terminos generales)</li>
  <li>Demostración de la Funcionalidad de mi aplicación :)</li>
</ul>

--------------------------
<h2>Explicación de la API </h2>
<p>Para el desarrollo del Proyecto conversor de monedas, se utilizo la Api <strong>ExchangeRate-API</strong> propuesta para el desarrollo del proyecto. Primeramente se obtiene el link junto con la <strong>APIKEY</strong> con la cual se haran las peticiones a dicha API:</p>

#### Por ejemplo, (codigo de mi autoria)
![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/70d491bc-30a9-4541-8991-9bc7c95928b8)

#### Resultado:
![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/953ac641-cb3a-4b2e-9b8d-ae3c4bd8c0cf)

<p>Este proyecto utilizara el "base_code" y "conversion_rates" como claves para su respectivo valor permitiendo obtener por medio de estos el valor de conversión y guardarlos en java de la siguiente forma:</p>

![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/92835b59-ad65-4dd3-87ca-2e3383746bb8)

--------------------------
<h2>Estructura y Logica del Proyecto (Explicacion en terminos generales)</h2>
<p>El desarrollo del proyecto fue mediante el patrón de objetos de acceso a datos <strong>DAO</strong> utilizando el sistema de carpetas de la siguiente forma: </p>

![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/1e8a92a2-dc67-4660-bf90-32649a4273a8)

<ul>
  <li>Carpeta models</li>
    <p>Contiene el modelo de la taza de cambio, utilizando una variable llamada (baseCoin) que me guarda el "base_code" de la moneda base y con una funcion que me guarda en la interfaz Map (conversionRates) la clave valor del "conversion_rates", por ejemplo: </p>

  ![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/7f5c7724-6c2f-403d-b97b-f6da50658ba9)

  ![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/b3a7673f-70ab-4b35-afdf-104f2e2365c7)

  <li>Carpeta dao</li>
    <p>Contiene la interfaz de la función <strong>getExchangeRate</strong> que como su nombre lo indica, se encarga de obtener el valor de la taza de cambio, haciendo la peticion a la URL con la moneda base y guardando en un String el <strong>json</strong> que seria convertido a objeto java con la dependencia de Google <strong>Gson</strong>, una vez obtengo los datos en Java puedo tratarlos en un BigDecimal (considerado el mejor para el manejo de valores de taza de cambio) finalmente returnando el valor de la clave que es pasada por el usuario en la interfaz grafica.</p>
  
  ![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/b44d1e07-b721-460c-bac0-f447df506e5a)

  <li>Carpeta design</li>
    <p>En esta carpeta se encuentra la logica de la interfaz grafica Swing en la cual se implementa la implementación del DAO (Valga la redondancia), una vez implementada imprime un JOptionPane para presentar en pantalla el resultado de la conversión, como se puede ver a continuación: </p>

  ![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/93a5ea50-8a16-49f9-94b4-db7c9d505b94)

</ul>


--------------------------
<h2>Demostración de la Funcionalidad de mi aplicación :)</h2>
<p>En el cuadro superior se presenta: La aplicación, El resultado y la Validación con la calculadora. En los cuadros inferiores se presentan los datos de conversion obtenidos de la Api (ExchangeRate) para hacer la prueba, la aplicacion consta de cuatro monedas posibles para seleccionar tanto como moneda base o tasa de cambio de moneda: </p>

### Multiple seleccion de Moneda Base
![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/db82a6b6-121e-456f-bfaa-3be636747f63)
### Multiple seleccion de Moneda de Cambio
![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/0cd6a304-ae68-4d0c-8a51-144eef8589e3)

## Ejemplo:
### USD ($10000) -> COP
![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/0433fa45-f47e-42df-bd4a-904cf72e0e4e)
### USD ($10000) -> CLP
![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/52cb33ae-47d8-442d-b4cc-0bd7811f344e)
### USD ($10000) -> BRL
![image](https://github.com/Juanmadrinan/challenge-two-conversor-monedas-one/assets/125837348/96b3702b-4eba-4e2e-ad94-abd70914184c)



----------------------------
