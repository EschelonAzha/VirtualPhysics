package symmetrical.physics.subatomic.forces.gravity
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

import symmetrical.physics.subatomic.bosons.Graviton
import symmetrical.physics.subatomic.spacial.Beam


// For more information visit:   https://en.wikipedia.org/wiki/Gravity


open class GravitationalField() {
    private var center      : GravitationalField? = null
    private val gravitons   : Beam = Beam()

    fun with(center:GravitationalField) : GravitationalField {
        this.center = center
        return this
    }
    fun orbit() : GravitationalField {
        return GravitationalField().with(this)
    }
    fun add(graviton:Graviton) : Graviton {
        gravitons.add(graviton)
        return graviton
    }
    fun remove(graviton:Graviton) : Graviton {
        return gravitons.remove(graviton) as Graviton
    }
}