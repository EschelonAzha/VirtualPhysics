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
import symmetrical.physics.subatomic.matter.colors.Blue
// For more information visit:   https://en.wikipedia.org/wiki/Gluon
class Green_AntiRed : Gluon() {
    init {
        color       = green()
        antiColor   = AntiRed()
    }

    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue().blue(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}