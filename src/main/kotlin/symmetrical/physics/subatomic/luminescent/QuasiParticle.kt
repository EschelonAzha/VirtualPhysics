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
import symmetrical.dictionary.quasiparticles.GalaxyId
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.transpectors.transpectors.Photons
import symmetrical.transpectors.transpectors.Strings
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.balanced.values.IField
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon


// For more information visit:   https://en.wikipedia.org/wiki/Quasiparticle

open class QuasiParticle(
    private val _field:Field=Field(),
    private val matterAntiMatter: IMatter = Matter().with(QuasiParticle::class)
) : IField by _field,
    IMatterAntiMatter by matterAntiMatter,
    IQuasiParticle
{

    fun with(value:Any?) : QuasiParticle {
        _field.setContent(value)
        return this
    }
    fun update(quasi:QuasiParticle) : QuasiParticle {
        setContent(quasi.getContent())
        return this
    }
    fun getField() : Field {
        return _field
    }
    override fun isIlluminated(): Boolean {
        return false
    }
    override fun manifest() : IEmitter? {
        return this
    }
    override fun toString() : String {
        return _field.toString()
    }







    // ########################### EMISSIONS ###########################
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
        if (type == Field.Static.ARRAY) {
            var (content, remainder) = Photons.parse(Field.Static.ARRAY_LTH, leftover)
            _field.setContent(content)
            return Photon().with(remainder)
        }
        println("!!!!!!!!!!!!!!!!!!!!!ERROR OCCURED IN QuasiParticle:absorb!!!!!!!!!!!!!!!!!!!!!")
        return Photon().with("")
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(QuasiParticle::class)
    }
    private fun radiate() : String {
        val prefix = matterAntiMatter.getClassId()+_field.getType()
        if (_field.getType() == Field.Static.NULL)
            return prefix
        if (_field.getType() == Field.Static.BOOLEAN)
            return prefix+ Strings.prefixBase52LthToString(1, _field.getContent())
        if (_field.getType() == Field.Static.BYTE)
            return prefix+ Strings.prefixBase52LthToString(1, _field.getContent())
        if (_field.getType() == Field.Static.INT)
            return prefix+ Strings.prefixBase52LthToString(1, _field.getContent())
        if (_field.getType() == Field.Static.DOUBLE)
            return prefix+ Strings.prefixBase52LthToString(1, _field.getContent())
        if (_field.getType() == Field.Static.STRING1)
            return prefix+ Strings.prefixBase52LthToString(1, _field.getContent())
        if (_field.getType() == Field.Static.STRING2)
            return prefix+ Strings.prefixBase52LthToString(2, _field.getContent())
        if (_field.getType() == Field.Static.STRING3)
            return prefix+ Strings.prefixBase52LthToString(3,_field.getContent())

        return prefix+ Strings.prefixBase52LthToString(3, _field.getContent())
    }
    // ########################### EMISSIONS ###########################


}