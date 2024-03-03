package symmetrical.physics.subatomic.balanced.fundamentals.angular_momentum
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
import symmetrical.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.IQuantum
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import kotlin.reflect.KClass

// For more information visit:   https://en.wikipedia.org/wiki/Angular_momentum

open class AngularMomentum(
    private val field: QuasiParticle = QuasiParticle()
) :
    IQuasiParticle by field
{
    fun withQuantum(quantum: IQuantum) : AngularMomentum {
        this.field.setQuantum(quantum)
        return this
    }
    companion object {
        fun field(atom: Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            return field(proton)
        }
        fun field(atom: Atom, classType:KClass<*>) : Field {
            val proton = atom.getProton(classType)
            return field(proton)
        }
        fun field(proton: Proton) : Field {
            return proton.getValueQuark().getAngularMomentum().getField()
        }
        fun run(atom: Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            return run(proton)
        }
        fun run(atom : Atom, classType:KClass<*>) : Field {
            val proton = atom.getProton(classType)
            return run(proton)
        }
        fun run(proton: Proton) : Field {
            var quark  : Quark = proton.getValueQuark()
            return quark.getAngularMomentum().run(Wavelength.field(proton))
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

    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AngularMomentum::class)
    }

    public open fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }

    fun momentum() : Any? {
        return field.getContent()
    }
    open fun run(arg: Field) : Field {
        return arg
    }
}