package symmetrical.physics.subatomic.balanced.fundamentals.spin
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
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.IQuantum
import symmetrical.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import kotlin.reflect.KClass

// For more information visit:   https://en.wikipedia.org/wiki/Spin_(physics)

class Spin(
    private val field: QuasiParticle = QuasiParticle().with(Static.PLUS)
) :
    IQuasiParticle by field
{

    init {
        field.setContent(Spin.Static.ZERO)
    }
    fun withQuantum(quantum: IQuantum) : Spin {
        this.field.setQuantum(quantum)
        return this
    }
    fun with(content:Int) : Spin {
        field.setContent(content)
        return this
    }

    object Static {
        const val PLUS :Int      = +1
        const val ZERO :Int      = 0
        const val MINUS:Int      = -1
    }

    fun getField() : Field {
        return field.getField()
    }

    fun isFalse() : Boolean {
        return isZero()
    }
    fun isMinus() : Boolean {
        return field.toInt() == -1
    }
    fun isPlus() : Boolean {
        return field.toInt() == 1
    }
    fun isTrue() : Boolean {
        return !isZero()
    }
    fun isZero() : Boolean {
        return field.toInt() == 0
    }

    override fun setContent(content:Any?) : Any? {
        if (content is Boolean) {
            if (content)
                return field.setContent(1)
            else return field.setContent(0)
        }
        return field.setContent(content)
    }

    fun spin() : Field {
        return field.getField()
    }

    fun spinPlus() : Spin {
        field.setContent(Spin.Static.PLUS)
        return this
    }
    fun spinMinus() : Spin {
        field.setContent(Spin.Static.MINUS)
        return this
    }
    fun spinZero() : Spin {
        field.setContent(Spin.Static.ZERO)
        return this
    }






    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Spin::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}