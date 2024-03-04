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


// For more information visit:   https://en.wikipedia.org/wiki/Gravity


open class Gravity() {

    private val gravitons : ArrayList<Graviton> = ArrayList<Graviton>()

    companion object {
        private lateinit var gravity : Gravity

        fun setForce(gravity: Gravity) : Gravity {
            Companion.gravity = gravity
            return gravity
        }
    }



    fun graviton(center: Graviton, attract:Unit, radial: Graviton) : Unit {
        val graviton = Graviton().with(center, attract, radial)
        gravitons.add(graviton)
        return attract
    }
}