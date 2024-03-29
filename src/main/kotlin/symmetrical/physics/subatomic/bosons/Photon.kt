package symmetrical.physics.subatomic.bosons
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

import asymmetrical.physics.machine.config.Config
import symmetrical.transpectors.printable_characters.Base52
import symmetrical.transpectors.transpectors.Photons

// For more information visit:   https://en.wikipedia.org/wiki/Photon

open class Photon(){
    lateinit    var emitter     : IEmitter
    var radiation   : String = ""

    // Spin 1
    fun with(radiation:String) : Photon {
        this.radiation = radiation;
        return this
    }

    fun propagate() : Photon {
        return Photon().with(Photons.chopClassId(radiation))
    }
    fun radiate() : String {
        return radiation
    }

    fun setEmitter(emitter: IEmitter) : Photon {
        this.emitter = emitter
        return this
    }

}