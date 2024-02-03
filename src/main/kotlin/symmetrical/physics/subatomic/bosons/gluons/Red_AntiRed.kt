package symmetrical.physics.subatomic.bosons.gluons
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

import symmetrical.physics.subatomic.matter.bosons.Gluon
import symmetrical.physics.subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.physics.subatomic.matter.colors.Red

// For more information visit:   https://en.wikipedia.org/wiki/Gluon
class Red_AntiRed : symmetrical.physics.subatomic.matter.bosons.Gluon() {

    init {
        color       = symmetrical.physics.subatomic.matter.colors.Red()
        antiColor   = symmetrical.physics.subatomic.anti_matter.anti_colors.AntiRed()
    }

    override fun getAntiValue() : Any? {
        return color._value
    }
    override fun setValue(value:Any?) : symmetrical.physics.subatomic.matter.bosons.Gluon {
        color.setValue(value)

        return this
    }
    fun red(charge: symmetrical.physics.subatomic.matter.bosons.Gluon) : Red_AntiRed {
        return this
    }
}