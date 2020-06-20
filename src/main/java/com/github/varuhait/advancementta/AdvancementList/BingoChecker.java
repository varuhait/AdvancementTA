package com.github.varuhait.advancementta.AdvancementList;

import java.util.List;

public class BingoChecker {
	public static int bingoCheck(int masu, List<Integer> card) {
		int point = 0;
		point += vertical(card, (masu%5)+1);
		point += holizontal(card, (int)(masu/5)+1);
		if(masu == 0 || masu % 6 == 0) {
			point += diagonalLeft(card);
		}else if(masu % 4 == 0) {
			point += diagonalRight(card);
		}
		return point;
	}

	private static int holizontal(List<Integer> gomoku, int line) {
		int st = (line - 1) * 5;
		int end = line * 5 -1;
		int own = 0;
		for(int i=st; i<end; i++) {
			switch(gomoku.get(i)) {
				case 0:
					return 0;
				case 1:
					if(own == 0) own = 1;
					else if(own == 2) return 0;
					break;
				case 2:
					if(own == 0) own = 2;
					else if(own == 1) return 0;
			}
		}
		return 50;
	}

	private static int vertical(List<Integer> gomoku, int line) {
		int st = line - 1;
		int end = line + 19;
		int own = 0;
		for(int i=st; i<=end; i+=5) {
			switch(gomoku.get(i)) {
			case 0:
				return 0;
			case 1:
				if(own == 0) own = 1;
				else if(own == 2) return 0;
				break;
			case 2:
				if(own == 0) own = 2;
				else if(own == 1) return 0;
			}
		}
		return 50;
	}

	private static int diagonalLeft(List<Integer> gomoku) {
		int own = 0;
		for(int i=0; i<=24; i+=6) {
			switch(gomoku.get(i)) {
			case 0:
				return 0;
			case 1:
				if(own == 0) own = 1;
				else if(own == 2) return 0;
				break;
			case 2:
				if(own == 0) own = 2;
				else if(own == 1) return 0;
			}
		}
		return 50;
	}


		private static int diagonalRight(List<Integer> gomoku) {
			int own = 0;
			for(int i=4; i<=20; i+=4) {
				switch(gomoku.get(i)) {
				case 0:
					return 0;
				case 1:
					if(own == 0) own = 1;
					else if(own == 2) return 0;
					break;
				case 2:
					if(own == 0) own = 2;
					else if(own == 1) return 0;
				}
			}
			return 50;
		}

}
