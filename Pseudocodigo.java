// La trama la defino como un Enum y es conocida por la prenda.

enum Trama {
  LISA,
  RAYADA,
//etc
}

public class Prenda {
  public Prenda(
      TipoDePrenda tipoDePrenda,
      Material material,
      Color colorPrincial,
      Color colorSecundario,
      Trama trama) {
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.color = color;
    // etc
  }
}

// Para el requerimiento del borrador creo la abstraccion Borrador. Con esto logro
// representar a una prenda de forma mutable. De esta forma la clase Borrador se encarga
// de crear la prenda y la clase Prenda resuelve el comportamiento de la misma.

class Borrador {
  constructor(tipoDePrenda) { // primera validacion necesaria
    validateNonNull(tipoDePrenda)
    this.tipoDePrenda = tipoDePrenda
  }

  // validaciones de no nulos
  method especificarColorPrincipal(color) {
    validateNonNull(color)
    this.colorPrincipal = color
  }

  method especificarMaterial(material) {
    validateNonNull(material)
    // validacion para evitar elegir material inconsistente con tipo de prenda
    this.validarMaterialConsistenteConTipoDePrenda(material)
    this.material = material
  }

  method crearPrenda() {
    // resto de las validaciones que sigan siendo necesarias
    return new Prenda(tipo, material, colorPrincipal, colorSecundario, trama)
  }
}

// Para que la trama sea por defecto LISA

class Borrador {
  attribute trama = Trama.LISA

  method especificarTrama(trama) {
    this.trama = if trama is null then Trama.LISA else trama
  }
}

// Uniforme: utilizo composicion para los distintos sastres (gano en extensibilidad)
// con un metodo de clase fabricar que instancia al uniforme y setea el sastre.

class Uniforme {
  attribute prendaSuperior
  attribute prendaInferior
  attribute calzado

  classmethod fabricar(Sastre sastre) {
    new Uniforme(
        sastre.fabricarParteSuperior(),
        sastre.fabricarParteInferior(),
        sastre.fabricarCalzado())
  }
}

interface Sastre {
  method fabricarParteSuperior()

  method fabricarParteInferior()

  method fabricarCalzado()
}

class SastreSanJuan implements Sastre {
  method fabricarParteSuperior() {
    borrador = new Borrador(CHOMBA)
    borrador.especificarColor(new Color(....))
    borrador.especificarMaterial(PIQUE)
    return borrador.crearPrenda()
  }

  method fabricarParteInferior() {
    borrador = new Borrador(PANTALON)
    borrador.especificarColor(new Color(....))
    borrador.especificarMaterial(ACETATO)
    return borrador.crearPrenda()
  }
  //etc
}