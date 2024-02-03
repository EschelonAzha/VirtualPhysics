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
import symmetrical.physics.subatomic.bosons.gluons.Green_AntiGreen

// For more information visit:   https://en.wikipedia.org/wiki/Color_charge

open class Green : symmetrical.physics.subatomic.matter.colors.Color() {

    init {
        color = GREEN
    }

    override fun clone() : symmetrical.physics.subatomic.matter.colors.Green {
        var result      = symmetrical.physics.subatomic.matter.colors.Green()
        result.setValue(_value)
        return result
    }
    open fun format(redValue:Any?) : Any? {
        return QCD().green(redValue)
    }
    open fun green(charge: symmetrical.physics.subatomic.matter.bosons.Gluon) : Green_AntiGreen {
        var gluon               = Green_AntiGreen()
        gluon.antiColor.setValue(charge.getAntiValue())
        gluon.color.setValue    (format(charge.getAntiValue()))
        return gluon
    }


}