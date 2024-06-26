package symmetrical.physics.dimensions

import asymmetrical.physics.machine.config.Config
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon

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
class Vacuum : IEmitter {

    companion object{

         fun getClassId() : String {
            if (Config.getClassIdLth() == 2)
                return "aa"
            else return "aaa"
        }
    }

    override fun isIlluminated(): Boolean {
        return false
    }
    override fun manifest() : IParticle? {
        return null
    }





    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    fun getClassId() : String {
        return Vacuum.getClassId()
    }
    private fun radiate() : String {
        return getClassId()
    }
    // ########################### EMISSIONS ###########################

}