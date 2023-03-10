package O_D;

/**
 * 缓存需要最少金币数 /静态扫描
 * 静态扫描可以快速识别源代码的缺陷，静态扫描的结果以扫描报告作为输出:
 *
 * 1、文件扫描的成本和文件大小相关，如果文件大小为N，则扫描成本为N个金币
 *
 * 2、扫描报告的缓存成本和文件大小无关，每缓存一个报告需要M个金币
 *
 * 3、扫描报告缓存后，后继再碰到该文件则不需要扫描成本，直接获取缓存结果给出源代码文件标识序列和文件大小序列，求解采用合理的缓存策略，最少需要的金币数
 *
 * 输入描述
 * 第一行为缓存一个报告金币数M，L<= M <= 100
 * 第二行为文件标识序列: F1,F2,F3,....,Fn。
 * 第三行为文件大小序列: S1,S2,S3,....,Sn。
 * 备注:
 * 1 <= N <= 10000
 * 1 <= Fi <= 1000
 * 1 <= Si <= 10
 * 输出描述
 * 采用合理的缓存策略，需要的最少金币数
 *
 * 示例1：
 * 5
 * 1 2 2 1 2 3 4
 *
 * 1 1 1 1 1 1 1
 * 输出
 * 7
 * 说明
 * 文件大小相同，扫描成本均为1个金币。缓存任意文件均不合算，因而最少成本为7金币。
 *
 * 示例2：
 *
 * 输入
 *
 * 5
 * 2 2 2 2 2 5 2 2 2
 * 3 3 3 3 3 1 3 3 3
 * 输出
 * 9
 */
public class StaticScanning {
}
