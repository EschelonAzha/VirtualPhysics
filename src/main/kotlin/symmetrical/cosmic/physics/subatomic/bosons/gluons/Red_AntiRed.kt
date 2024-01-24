package symmetrical.cosmic.physics.subatomic.bosons.gluons
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

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic.physics.subatomic.matter.colors.Red


class Red_AntiRed : Gluon() {

    init {
        color       = Red()
        antiColor   = AntiRed()
    }

    override fun getAntiValue() : Any? {
        return color._value
    }
    override fun setValue(value:Any?) : Gluon {
        color.setValue(value)

        return this
    }
    fun red(charge: Gluon) : Red_AntiRed {
        return this
    }
}