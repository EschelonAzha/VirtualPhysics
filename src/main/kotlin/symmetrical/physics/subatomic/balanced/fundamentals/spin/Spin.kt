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

    var quantum : IQuantum? = null

    fun withQuantum(quantum: IQuantum) : Spin {
        this.quantum = quantum
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

    companion object {
        fun isMinus(atom: Atom) : Boolean {
            return isMinus(atom.getProton(ValueProton::class))
        }
        fun isMinus(atom: Atom, classType: KClass<*>) : Boolean {
            return isMinus(atom.getProton(classType))
        }
        fun isMinus(proton: Proton) : Boolean {
            var quark  : Quark = proton.getValueQuark()
            return isMinus(quark)
        }
        fun isMinus(quark: Quark) : Boolean {
            return quark.getSpin().spin().toBoolean()
        }
        fun isPlus(atom: Atom) : Boolean {
            return isPlus(atom.getProton(ValueProton::class))
        }
        fun isPlus(atom: Atom, classType: KClass<*>) : Boolean {
            return isPlus(atom.getProton(classType))
        }
        fun isPlus(proton: Proton) : Boolean {
            var quark  : Quark = proton.getValueQuark()
            return isPlus(quark)
        }
        fun isPlus(quark: Quark) : Boolean {
            return quark.getSpin().spin().toBoolean()
        }
        //
        fun isZero(atom: Atom) : Boolean {
            return isZero(atom.getProton(ValueProton::class))
        }
        fun isZero(atom: Atom, classType: KClass<*>) : Boolean {
            return isZero(atom.getProton(classType))
        }
        fun isZero(proton: Proton) : Boolean {
            var quark  : Quark = proton.getValueQuark()
            return isZero(quark)
        }
        fun isZero(quark: Quark) : Boolean {
            return quark.getSpin().spin().toBoolean()
        }
    }


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
    fun getField() : Field {
        return field.getField()
    }

    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Spin::class)
    }
    fun isPlus() : Boolean {
        return field.toInt() == 1
    }
    fun isMinus() : Boolean {
        return field.toInt() == -1
    }
    fun isZero() : Boolean {
        return field.toInt() == 0
    }

    fun setSpin(content:Any?) : Any? {
        if (content is Boolean) {
            if (content)
                return setContent(1)
            else return setContent(0)
        }

        return setContent(content)
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


}