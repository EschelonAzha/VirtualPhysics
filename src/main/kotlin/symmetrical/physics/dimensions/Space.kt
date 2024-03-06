package symmetrical.physics.dimensions
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

import symmetrical.dictionary.absorber.Absorber
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.balanced.IQuantum
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.physics.subatomic.luminescent.QuasiParticle

// For more information visit:   https://en.wikipedia.org/wiki/Space

class Space (
    private val field: QuasiParticle = QuasiParticle()
) :
    IQuasiParticle by field
{

    private var space: IParticle? = null   // this may have to change to a Particle UniqueId when emitted

    fun withQuantum(quantum: IQuantum) : Space {
        this.field.setQuantum(quantum)
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon = photon.propagate()
        remainder = field.absorb(remainder)
        if (remainder.radiation.startsWith("aa")) {
            return remainder.propagate()
        } else {
            val (emitter, spaceRemainder) = Absorber.materialize(remainder)
            space = emitter as IParticle
            return Photon().with(spaceRemainder)
        }
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }
    override fun getContent() : IParticle? {
        return space
    }
    override fun setContent(any:Any?) : Any? {
        return setSpace(any as IParticle?)
    }

    fun space() : Any? {
        return field.getContent()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Space::class)
    }
    private fun radiate() : String {
        val classId         :String = getLocalClassId()
        val quasi           :String = field.emit().radiate()
        var spaceRadiation  :String = "aa"
        if (space != null)
            spaceRadiation = space!!.emit().radiate()
        return classId+quasi+spaceRadiation
    }
    private fun setSpace(particle: IParticle?) : Space {
        this.space = particle
        return this
    }
}