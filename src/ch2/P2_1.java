package ch2;

import java.util.Scanner;

//顺序表操作实例
class DATA {
	String key; // 结点的关键字
	String name;
	int age;
}

class SLType { // 定义顺序表结构
	static final int MAXLEN = 5;
	DATA[] ListData = new DATA[MAXLEN + 1]; // 保存顺序表的结构数组
	int ListLen; // 顺序表已经保存的结点的数量

	void SLInit(SLType SL) { // 初始化顺序表
		SL.ListLen = 0; // 初始化表为空表
	}

	int SLLength(SLType SL) {
		return SL.ListLen; // 返回顺序列表元素数量
	}

	int SLInsert(SLType SL, int n, DATA data) { // n为插入结点的序号
		int i;
		if (SL.ListLen >= MAXLEN) { // 顺序表结点数量已超过最大数量
			System.out.println("顺序表已满，不能插入结点！\n");
			return 0;
		}
		if (n < 1 || n > SL.ListLen - 1) { // 插入结点序号不正确
			System.out.println("插入元素序号错误，不能插入元素！\n");
			return 0;
		}
		for (i = SL.ListLen; i >= n; i--) { // 将顺序表中的数据向后移动
			SL.ListData[i + 1] = SL.ListData[i];
		}
		SL.ListData[n] = data; // 插入结点
		SL.ListLen++; // 顺序表结点数量加1
		return 1; // 成功插入，返回1
	}

	int SLAdd(SLType SL, DATA data) {
		if (SL.ListLen >= MAXLEN) {
			System.out.println("顺序表已满，不能再添加结点了！\n");
			return 0;
		}
		SL.ListData[++SL.ListLen] = data;
		return 1;
	}

	int SLDelete(SLType SL, int n) {
		int i;
		if (n < 1 || n > SL.ListLen + 1) {
			System.out.println("删除结点序号错误，不能删除！\n");
			return 0;
		}
		for (i = n; i < SL.ListLen; i++) {
			SL.ListData[i] = SL.ListData[i + 1]; // 将顺序表中的数据向前移动
		}
		SL.ListLen--;
		return 1;
	}

	DATA SLFindByNum(SLType SL, int n) {
		if (n < 1 || n > SL.ListLen + 1) {
			return null;
		}
		return SL.ListData[n];
	}

	int SLFindByCont(SLType SL, String key) {
		int i;
		for (i = 1; i <= SL.ListLen; i++) {
			if (SL.ListData[i].key.compareTo(key) == 0) {
				return i;
			}
		}
		return 0;
	}

	int SLAll(SLType SL) { // 显示顺序表中的所有结点
		int i;
		for (i = 1; i <= SL.ListLen; i++) {
			System.out.println("key:" + SL.ListData[i].key + ",name:"
					+ SL.ListData[i].name + ",age:" + SL.ListData[i].age);
		}
		return 0;
	}
}

public class P2_1 {

	public static void main(String[] args) {
		int i;
		SLType SL = new SLType();
		DATA pdata;
		String key;
		SL.SLInit(SL);
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("请输入添加的结点信息：学号姓名年龄");
			DATA data = new DATA();
			data.key = input.next();
			data.name = input.next();
			data.age = input.nextInt();

			if (data.age != 0) {
				if (SL.SLAdd(SL, data) == 0) {
					break;
				}
			} else {
				break;
			}
		} while (true);
		System.out.println("\n顺序表中的结点顺序为：\n");
		SL.SLAll(SL);

		System.out.println("\n要取出结点的序号：");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if (pdata != null) {
			System.out.println("第四个%d" + i + pdata.key + pdata.name
					+ pdata.age);
		}

		System.out.println("\n要查找的关键字：");
		key = input.next();
		i = SL.SLFindByCont(SL, key);
		pdata = SL.SLFindByNum(SL, i);
		if (pdata != null) {
			System.out.println("结点为：" + i + pdata.key + pdata.name + pdata.age);
		}
		input.close();
	}
}
