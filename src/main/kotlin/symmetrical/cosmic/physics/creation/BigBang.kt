package symmetrical.cosmic.physics.creation
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


import asymmetrical.physics.machine.threads.Cores

class BigBang  {
    constructor()

    private lateinit var universe       : Universe
    var cores                           : Cores = Cores()
    fun i(universe: Universe) : BigBang {
        this.universe = universe;
        //  BootConfig.UNIVERSE = universe
        return this;
    }

    fun run() : Unit {
        // this runs a console app
        this.universe.run()
    }
    fun runUI() : Unit {
        // this starts and runs the browser UI
        //   Application.launch(FxLauncher::class.java)
    }

}