package symmetrical.dictionary.quasiparticles
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

import asymmetrical.physics.machine.config.Config
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.transpectors.printable_characters.Base52

class GalaxyId (
    private val matterAntiMatter: IMatter = Matter().with(GalaxyId::class)
) : QuasiParticle(),
    IMatterAntiMatter by matterAntiMatter
{

    fun with(content:String) : GalaxyId {
        setContent(content)
        return this
    }

    fun getRemoteId() : RemoteId {
        val id = Base52.toFixedBase52(Config.getGalaxyIdLth(), toInt() + Base52.Static.MAX_SESSIONS)
        return RemoteId().with(id) as RemoteId
    }
    fun setGalaxyId(galaxyId:GalaxyId) : GalaxyId {
        setContent(galaxyId.toString())
        return this
    }
    override fun toInt() : Int {
        val id = toString()
        return Base52.toInt(id)
    }





    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}