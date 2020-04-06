/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.contract.stubrunner;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.util.FileUtils;

class TestUtils {

	public static void prepareLocalRepo() throws IOException {
		prepareLocalRepo("target/test-classes/git_samples/", "contract-git");
		prepareLocalRepo("target/test-classes/git_samples/",
				"contract-predefined-names-git");
	}

	private static void prepareLocalRepo(String buildDir, String repoPath)
			throws IOException {
		File dotGit = new File(buildDir + repoPath + "/.git");
		File git = new File(buildDir + repoPath + "/git");
		if (git.exists()) {
			if (dotGit.exists()) {
				FileUtils.delete(dotGit, FileUtils.RECURSIVE);
			}
		}
		git.renameTo(dotGit);
	}

}
