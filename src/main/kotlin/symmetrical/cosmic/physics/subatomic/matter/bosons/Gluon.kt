package symmetrical.cosmic.physics.subatomic.matter.bosons
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

import symmetrical.cosmic.physics.subatomic.matter.colors.Color
import symmetrical.cosmic.physics.subatomic.matter.colors.Green
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiColor
import symmetrical.cosmic.physics.subatomic.balanced.Particle




/*
https://en.wikipedia.org/wiki/Gluon
 */
// Transformations are in Gluons and use different mixtures of colors to accomplish anything
// for example AND and OR and XOR
open class Gluon : Particle() {
    // Gluons are confined within
    // Spin 1
    lateinit var color      : Color
    lateinit var antiColor  : AntiColor

    var manifestation : Green = Green()


    fun exchange() : PlusPion {
        // incomplete.  My thinking is that value will be
        // reflected in Neutrons that are inert
        // get the new value, then become charged (proton)
        // then transmit their charges to the value proton
        // then become Neutrons again.  (Not sure if this is necessary
        // but something to think about.


        var pion = PlusPion() // pull quarks from the vacuum
//        pion.quarks[0].gluon.setValue(color.value)
//
//        color.value = antiColor.value
        return pion
    }
    open fun getAntiValue() : Any? {
        return antiColor._value
    }
    fun green() : Green {
        return manifestation.clone()
    }
    fun setGreen(green: Green) : Gluon {
        this.manifestation = green
        return this
    }
    public open fun setValue(value:Any?) : Gluon {
        color.setValue(value)
        antiColor.setValue(value)

        return this
    }



}