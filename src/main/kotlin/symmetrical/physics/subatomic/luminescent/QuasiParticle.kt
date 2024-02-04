package symmetrical.physics.subatomic.luminescent
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
import symmetrical.transpectors.transpectors.Photons
import symmetrical.transpectors.transpectors.Strings
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.balanced.values.IField
import symmetrical.physics.subatomic.bosons.Photon


// For more information visit:   https://en.wikipedia.org/wiki/Quasiparticle

class QuasiParticle(
    private val _field:Field=Field()
) : IField by _field,
    IQuasiParticle
{

    fun with(value:Any?) : QuasiParticle {
        _field.setContent(value)
        return this
    }

    override fun absorb(photon: Photon) : Photon {

        var (type, leftover) = Strings.remainder(Field.Static.TYPE_LTH, photon.propagate().radiate())
        if (type == Field.Static.NULL) {
            _field.setContent(null)
            return Photon().with(leftover)
        }
        if (type == Field.Static.BOOLEAN) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content == "true")
            return Photon().with(remainder)
        }
        if (type == Field.Static.BYTE) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content)
            return Photon().with(remainder)
        }
        if (type == Field.Static.INT) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content.toInt())
            return Photon().with(remainder)
        }
        if (type == Field.Static.DOUBLE) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content.toDouble())
            return Photon().with(remainder)
        }
        if (type == Field.Static.STRING1) {
            var (content, remainder) = Photons.parse(Field.Static.STRING1_LTH, leftover)
            _field.setContent(content)
            return Photon().with(remainder)
        }
        if (type == Field.Static.STRING2) {
            var (content, remainder) = Photons.parse(Field.Static.STRING2_LTH, leftover)
            _field.setContent(content)
            return Photon().with(remainder)
        }
        if (type == Field.Static.STRING3) {
            var (content, remainder) = Photons.parse(Field.Static.STRING3_LTH, leftover)
            _field.setContent(content)
            return Photon().with(remainder)
        }
        if (type == Field.Static.VECTOR) {
            var (content, remainder) = Photons.parse(Field.Static.VECTOR_LTH, leftover)
            _field.setContent(content)
            return Photon().with(remainder)
        }
        println("!!!!!!!!!!!!!!!!!!!!!ERROR OCCURED IN QuantumPhotonicField:ABSORB!!!!!!!!!!!!!!!!!!!!!")
        return Photon().with("")
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    public fun getClassId() : String {
        return getLocalClassId()
    }

    fun getField() : Field {
        return _field
    }

    fun radiate() : String {
        val prefix = getLocalClassId()+_field.getType()
        if (_field.getType() == Field.Static.NULL)
            return prefix
        if (_field.getType() == Field.Static.BOOLEAN)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.BYTE)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.INT)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.DOUBLE)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.STRING1)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.STRING2)
            return prefix+ Photon.toPhoton2(_field.getContent())
        if (_field.getType() == Field.Static.STRING3)
            return prefix+ Photon.toPhoton3(_field.getContent())

        return prefix+ Photon.toPhoton3(_field.getContent())
    }

    override fun toString() : String {
        return _field.toString()
    }

    private fun getLocalClassId() : String {
        return symmetrical.dictionary.absorber.Absorber.getClassId(QuasiParticle::class)
    }
}