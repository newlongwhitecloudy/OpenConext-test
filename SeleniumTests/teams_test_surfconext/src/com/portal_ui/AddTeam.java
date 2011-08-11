/*
 * Copyright 2011 SURFnet bv, The Netherlands
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.portal_ui;

public class AddTeam extends Login {

    public void testSignIn() throws Exception {
		login();
    	verifyTrue(selenium.isTextPresent("Logout"));
		selenium.open("/teams/");
		selenium.click("link=Add Team");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=TeamName", "teamteamteam");
		selenium.type("id=TeamDescription", "team");
		selenium.click("id=TeamConsent");
		selenium.click("id=TeamViewability");
		selenium.click("name=createTeam");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=< Back to teams");
    }
}