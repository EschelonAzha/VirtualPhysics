package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber


open class Characters {

    private var _characters:String  = "";
    constructor() {
    }

    fun i(characters:String) : Characters {
        this._characters = characters;
        return this;
    }
    fun indexOf(pos: Int) : String? {
        if (pos > this.getCharacters().length-1) {
            return null
        }
        return this.getCharacters()[pos].toString();
    }
    fun getCharacters() : String {
        return this._characters;
    }
    fun valueOf(character:String) : Int {
        val index = this.getCharacters().indexOf(character);
        return index;
    }
}