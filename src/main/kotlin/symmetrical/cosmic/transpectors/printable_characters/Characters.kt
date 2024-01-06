package symmetrical.cosmic.transpectors.printable_characters
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */




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