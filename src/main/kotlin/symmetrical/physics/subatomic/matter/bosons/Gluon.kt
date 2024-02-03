package symmetrical.physics.subatomic.matter.bosons
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

import symmetrical.physics.subatomic.matter.colors.Color
import symmetrical.physics.subatomic.matter.colors.Green
import symmetrical.physics.subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.physics.subatomic.anti_matter.anti_colors.AntiColor
import symmetrical.physics.subatomic.balanced.Particle





// For more information visit:   https://en.wikipedia.org/wiki/Gluon

// Transformations are in Gluons and use different mixtures of colors to accomplish anything
// for example AND and OR and XOR
open class Gluon : symmetrical.physics.subatomic.balanced.Particle() {
    // Gluons are confined within
    // Spin 1
    lateinit var color      : symmetrical.physics.subatomic.matter.colors.Color
    lateinit var antiColor  : symmetrical.physics.subatomic.anti_matter.anti_colors.AntiColor

    var manifestation : symmetrical.physics.subatomic.matter.colors.Green =
        symmetrical.physics.subatomic.matter.colors.Green()


    fun exchange() : symmetrical.physics.subatomic.matter.hadrons.mesons.PlusPion {
        // incomplete.  My thinking is that value will be
        // reflected in Neutrons that are inert
        // get the new value, then become charged (proton)
        // then transmit their charges to the value proton
        // then become Neutrons again.  (Not sure if this is necessary
        // but something to think about.


        var pion = symmetrical.physics.subatomic.matter.hadrons.mesons.PlusPion() // pull quarks from the vacuum
//        pion.quarks[0].gluon.setValue(color.value)
//
//        color.value = antiColor.value
        return pion
    }
    open fun getAntiValue() : Any? {
        return antiColor._value
    }
    fun green() : symmetrical.physics.subatomic.matter.colors.Green {
        return manifestation.clone()
    }
    fun setGreen(green: symmetrical.physics.subatomic.matter.colors.Green) : symmetrical.physics.subatomic.matter.bosons.Gluon {
        this.manifestation = green
        return this
    }
    public open fun setValue(value:Any?) : symmetrical.physics.subatomic.matter.bosons.Gluon {
        color.setValue(value)
        antiColor.setValue(value)

        return this
    }



}