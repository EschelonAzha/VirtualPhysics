package symmetrical.physics.subatomic.matter.colors
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
import symmetrical.physics.subatomic.balanced.color.QCD
import symmetrical.physics.subatomic.bosons.gluons.Blue_AntiBlue

// For more information visit:   https://en.wikipedia.org/wiki/Color_charge


open class Blue : symmetrical.physics.subatomic.matter.colors.Color() {

    init {
        color = BLUE
    }

    override fun clone() : symmetrical.physics.subatomic.matter.colors.Blue {
        var result      = symmetrical.physics.subatomic.matter.colors.Blue()
        result.setValue(_value)
        return result
    }
    fun blue(charge: symmetrical.physics.subatomic.matter.bosons.Gluon) : Blue_AntiBlue {
        var gluon = Blue_AntiBlue()
        gluon.color.setValue    (QCD().blue(charge.getAntiValue()))
        gluon.antiColor.setValue(charge.getAntiValue())

        return gluon
    }

}