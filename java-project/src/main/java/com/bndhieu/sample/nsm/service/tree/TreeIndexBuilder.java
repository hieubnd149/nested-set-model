package com.bndhieu.sample.nsm.service.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hieubui
 * @date Nov 28, 2018
 *
 */
public class TreeIndexBuilder {

	public class TreeIndex {
		private final int value;
		private int left;
		private int right;

		public TreeIndex(final int value) {
			this.value = value;
		}

		public int getLeft() {
			return left;
		}

		public void setLeft(int left) {
			this.left = left;
		}

		public int getRight() {
			return right;
		}

		public void setRight(int right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return value + "[" + left + "," + right + "]";
		}
	}

	public List<TreeIndex> build(int[] sortedLevels) {
		List<TreeIndex> indexes = new ArrayList<>(sortedLevels.length);
		buildTreeIndex(indexes, sortedLevels, 0, 0);
		return indexes;
	}

	private TreeIndex buildTreeIndex(List<TreeIndex> indexes, int[] sortedLevels,
			final int treeNodeCount, final int index) {
		int count = treeNodeCount + 1;

		TreeIndex tbi = new TreeIndex(sortedLevels[index]);
		tbi.setLeft(count);
		indexes.add(tbi);

		final int nodeValue = sortedLevels[index];
		final int childValue = nodeValue + 1;
		for (int i = index + 1; i < sortedLevels.length; ++i) {
			if (nodeValue >= sortedLevels[i]) {
				break;
			}

			if (childValue == sortedLevels[i]) {
				count = buildTreeIndex(indexes, sortedLevels, count, i).getRight();
			}
		}
		tbi.setRight(count + 1);

		return tbi;
	}

}
