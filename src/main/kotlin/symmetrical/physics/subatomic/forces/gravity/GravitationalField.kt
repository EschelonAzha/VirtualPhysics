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
import symmetrical.physics.subatomic.spacial.ParticleBeam
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
    override fun deorbit() : GravitationalField {
        this.orbits = null
        return this
    }
    override fun eject(item:Any) : GravitationalField {
        val removed:Any? = beam.remove(item)
        if (removed != null) {
            return this
        }
        if (orbits == null) {
            return this
        }
        return orbits!!.eject(item)
    }
    override fun gravitate(kClass: KClass<*>) : Any? {
        val pos = beam.findByType(kClass)
        if (pos != -1)
            return beam.get(pos)
        if (gravity!!::class == kClass)
            return gravity
        if (orbits == null)
            return null
        return orbits!!.gravitate(kClass)
    }
    override fun gravitateAll(kClass: KClass<*>, result:Beam) : Beam {
        val found:Beam = beam.findAllByType(kClass)
        result.addAll(found)
        if (gravity!!::class == kClass)
            result.add(gravity)
        if (orbits == null)
            return result
        return orbits!!.gravitateAll(kClass, result)
    }
    override fun orbit(orbits:IGravitationalField) : GravitationalField {
        this.orbits = orbits
        return this
    }

    override fun setGravity(gravity:IGravity) : GravitationalField {
        this.gravity = gravity
        return this
    }


}