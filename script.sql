USE [repair]
GO
/****** Object:  User [repair]    Script Date: 21.11.2016 15:44:28 ******/
CREATE USER [repair] FOR LOGIN [repair] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  StoredProcedure [dbo].[AutoByYear]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[AutoByYear]
	@year int

	AS
	
	SELECT * FROM [dbo].[Auto] where [dbo].[Auto].[Year] > @year;

GO
/****** Object:  StoredProcedure [dbo].[Name]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[Name]

	AS
	
	SELECT * FROM [dbo].[Auto]

GO
/****** Object:  Table [dbo].[Cars]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cars](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[model_id] [int] NOT NULL,
	[number] [nchar](10) NOT NULL,
	[vin] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Cars_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Clients]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Clients](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[phone] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Clients] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Models]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Models](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Models_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Repair]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Repair](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[car_id] [int] NOT NULL,
	[client_id] [int] NOT NULL,
	[start_date] [datetime] NOT NULL,
	[end_date] [datetime] NULL,
	[done] [bit] NOT NULL,
 CONSTRAINT [PK_Repair] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Services]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Services](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[price] [int] NOT NULL,
 CONSTRAINT [PK_Services] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Workers]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Workers](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[speciality] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Workers_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[workUnit]    Script Date: 21.11.2016 15:44:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[workUnit](
	[worker_id] [int] NOT NULL,
	[service_id] [int] NOT NULL,
	[repair_id] [int] NOT NULL,
	[done] [bit] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_workUnit] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Cars] ON 

INSERT [dbo].[Cars] ([id], [model_id], [number], [vin]) VALUES (2, 3, N'ds1231dda ', N'123123123123')
INSERT [dbo].[Cars] ([id], [model_id], [number], [vin]) VALUES (3, 1, N'asdw112   ', N'sasdasd')
INSERT [dbo].[Cars] ([id], [model_id], [number], [vin]) VALUES (26, 3, N'o5a       ', N'asdasd123cxzcadsddscc')
INSERT [dbo].[Cars] ([id], [model_id], [number], [vin]) VALUES (33, 3, N'o5ssa     ', N'asdasd123cxzc')
SET IDENTITY_INSERT [dbo].[Cars] OFF
SET IDENTITY_INSERT [dbo].[Clients] ON 

INSERT [dbo].[Clients] ([id], [name], [phone]) VALUES (1, N'Вася', N'8 906 223 33 22')
INSERT [dbo].[Clients] ([id], [name], [phone]) VALUES (2, N'Петя', N'7 903 234 12 23')
INSERT [dbo].[Clients] ([id], [name], [phone]) VALUES (5, N'семен', N'8 906 554 32 44')
INSERT [dbo].[Clients] ([id], [name], [phone]) VALUES (7, N'семен', N'8 906 554 32 45')
INSERT [dbo].[Clients] ([id], [name], [phone]) VALUES (8, N'семен', N'8 906 5543 32 45')
SET IDENTITY_INSERT [dbo].[Clients] OFF
SET IDENTITY_INSERT [dbo].[Models] ON 

INSERT [dbo].[Models] ([id], [name]) VALUES (1, N'Nissan Silvia')
INSERT [dbo].[Models] ([id], [name]) VALUES (2, N'Toyota Mark 2')
INSERT [dbo].[Models] ([id], [name]) VALUES (3, N'Toyota Chaser')
INSERT [dbo].[Models] ([id], [name]) VALUES (4, N'Mitsubishi Lancer Evolution')
SET IDENTITY_INSERT [dbo].[Models] OFF
SET IDENTITY_INSERT [dbo].[Repair] ON 

INSERT [dbo].[Repair] ([id], [car_id], [client_id], [start_date], [end_date], [done]) VALUES (3, 2, 1, CAST(0x0000A4D900000000 AS DateTime), NULL, 0)
INSERT [dbo].[Repair] ([id], [car_id], [client_id], [start_date], [end_date], [done]) VALUES (4, 3, 2, CAST(0x0001232100000000 AS DateTime), NULL, 1)
INSERT [dbo].[Repair] ([id], [car_id], [client_id], [start_date], [end_date], [done]) VALUES (5, 2, 2, CAST(0x0000A6C500000000 AS DateTime), NULL, 0)
INSERT [dbo].[Repair] ([id], [car_id], [client_id], [start_date], [end_date], [done]) VALUES (8, 3, 2, CAST(0x0000A6C4017B78F5 AS DateTime), NULL, 0)
INSERT [dbo].[Repair] ([id], [car_id], [client_id], [start_date], [end_date], [done]) VALUES (13, 3, 1, CAST(0x0000A6C4017E0DF9 AS DateTime), NULL, 0)
INSERT [dbo].[Repair] ([id], [car_id], [client_id], [start_date], [end_date], [done]) VALUES (14, 3, 1, CAST(0x0000A6C4017E13DD AS DateTime), NULL, 0)
SET IDENTITY_INSERT [dbo].[Repair] OFF
SET IDENTITY_INSERT [dbo].[Services] ON 

INSERT [dbo].[Services] ([id], [name], [price]) VALUES (1, N'Замена масла', 1000)
INSERT [dbo].[Services] ([id], [name], [price]) VALUES (2, N'Шиномонтаж', 1500)
INSERT [dbo].[Services] ([id], [name], [price]) VALUES (3, N'Мойка двигателя', 700)
INSERT [dbo].[Services] ([id], [name], [price]) VALUES (4, N'Полировка', 1000)
SET IDENTITY_INSERT [dbo].[Services] OFF
SET IDENTITY_INSERT [dbo].[Workers] ON 

INSERT [dbo].[Workers] ([id], [name], [speciality]) VALUES (1, N'Олег', N'Мастер')
INSERT [dbo].[Workers] ([id], [name], [speciality]) VALUES (2, N'Ждон', N'Маляр')
INSERT [dbo].[Workers] ([id], [name], [speciality]) VALUES (3, N'Сэм', N'Механик')
SET IDENTITY_INSERT [dbo].[Workers] OFF
SET IDENTITY_INSERT [dbo].[workUnit] ON 

INSERT [dbo].[workUnit] ([worker_id], [service_id], [repair_id], [done], [id]) VALUES (3, 4, 3, 0, 40)
INSERT [dbo].[workUnit] ([worker_id], [service_id], [repair_id], [done], [id]) VALUES (1, 1, 3, 0, 41)
INSERT [dbo].[workUnit] ([worker_id], [service_id], [repair_id], [done], [id]) VALUES (2, 3, 3, 0, 42)
SET IDENTITY_INSERT [dbo].[workUnit] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Cars]    Script Date: 21.11.2016 15:44:28 ******/
ALTER TABLE [dbo].[Cars] ADD  CONSTRAINT [IX_Cars] UNIQUE NONCLUSTERED 
(
	[vin] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Cars_1]    Script Date: 21.11.2016 15:44:28 ******/
ALTER TABLE [dbo].[Cars] ADD  CONSTRAINT [IX_Cars_1] UNIQUE NONCLUSTERED 
(
	[number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Clients]    Script Date: 21.11.2016 15:44:28 ******/
ALTER TABLE [dbo].[Clients] ADD  CONSTRAINT [IX_Clients] UNIQUE NONCLUSTERED 
(
	[phone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cars]  WITH CHECK ADD  CONSTRAINT [FK_Cars_Cars] FOREIGN KEY([id])
REFERENCES [dbo].[Cars] ([id])
GO
ALTER TABLE [dbo].[Cars] CHECK CONSTRAINT [FK_Cars_Cars]
GO
ALTER TABLE [dbo].[Cars]  WITH CHECK ADD  CONSTRAINT [FK_Cars_Cars1] FOREIGN KEY([id])
REFERENCES [dbo].[Cars] ([id])
GO
ALTER TABLE [dbo].[Cars] CHECK CONSTRAINT [FK_Cars_Cars1]
GO
ALTER TABLE [dbo].[Cars]  WITH CHECK ADD  CONSTRAINT [FK_Cars_Models] FOREIGN KEY([model_id])
REFERENCES [dbo].[Models] ([id])
GO
ALTER TABLE [dbo].[Cars] CHECK CONSTRAINT [FK_Cars_Models]
GO
ALTER TABLE [dbo].[Repair]  WITH CHECK ADD  CONSTRAINT [FK_Repair_Cars] FOREIGN KEY([car_id])
REFERENCES [dbo].[Cars] ([id])
GO
ALTER TABLE [dbo].[Repair] CHECK CONSTRAINT [FK_Repair_Cars]
GO
ALTER TABLE [dbo].[Repair]  WITH CHECK ADD  CONSTRAINT [FK_Repair_Clients] FOREIGN KEY([client_id])
REFERENCES [dbo].[Clients] ([id])
GO
ALTER TABLE [dbo].[Repair] CHECK CONSTRAINT [FK_Repair_Clients]
GO
ALTER TABLE [dbo].[workUnit]  WITH CHECK ADD  CONSTRAINT [FK_workUnit_Repair] FOREIGN KEY([repair_id])
REFERENCES [dbo].[Repair] ([id])
GO
ALTER TABLE [dbo].[workUnit] CHECK CONSTRAINT [FK_workUnit_Repair]
GO
ALTER TABLE [dbo].[workUnit]  WITH CHECK ADD  CONSTRAINT [FK_workUnit_Services] FOREIGN KEY([service_id])
REFERENCES [dbo].[Services] ([id])
GO
ALTER TABLE [dbo].[workUnit] CHECK CONSTRAINT [FK_workUnit_Services]
GO
ALTER TABLE [dbo].[workUnit]  WITH CHECK ADD  CONSTRAINT [FK_workUnit_Workers] FOREIGN KEY([worker_id])
REFERENCES [dbo].[Workers] ([id])
GO
ALTER TABLE [dbo].[workUnit] CHECK CONSTRAINT [FK_workUnit_Workers]
GO
