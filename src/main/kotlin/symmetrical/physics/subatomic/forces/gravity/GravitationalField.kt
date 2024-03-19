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
import kotlin.reflect.KClass


// For more information visit:   https://en.wikipedia.org/wiki/Gravity


open class GravitationalField : IGravitationalField {
    private var beam        : Beam                 = Beam()
    private var gravity     : IGravity?            = null
    private var orbits      : IGravitationalField? = null


    override fun attract(item:Any) : GravitationalField {
        beam.add(item)
        return this
    }
    override fun gravitateTo(kClass: KClass<*>) : Any? {
        val pos = beam.findByType(kClass)
        if (pos != -1)
            return beam.get(pos)
        if (gravity!!::class == kClass)
            return gravity
        if (orbits == null)
            return null
        return orbits!!.gravitateTo(kClass)
    }
    override fun orbit(orbits:IGravitationalField) : GravitationalField {
        this.orbits = orbits
        return this
    }

    override fun remove(item:Any) : GravitationalField {
        beam.remove(item)
        return this
    }

    override fun setGravity(gravity:IGravity) : GravitationalField {
        this.gravity = gravity
        return this
    }

}